package io.holunda.command.handler;

import io.holunda.command.api.StartProcessByKeyCommand;
import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.command.api.mapper.ProcessInstanceMapper;
import io.holunda.command.api.model.BusinessKey;
import io.holunda.command.api.model.CaseInstanceId;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;

public class StartProcessByKeyHandler {

  private final RuntimeService runtimeService;

  public StartProcessByKeyHandler(final RuntimeService runtimeService) {
    this.runtimeService = runtimeService;
  }

  public ProcessInstanceDto handle(final StartProcessByKeyCommand cmd) {
    final ProcessInstantiationBuilder builder = runtimeService.createProcessInstanceByKey(cmd.getProcessDefinitionKey().value());

    builder.businessKey(cmd.getBusinessKey().map(BusinessKey::value).orElse(null));
    builder.caseInstanceId(cmd.getCaseInstanceId().map(CaseInstanceId::value).orElse(null));
    builder.setVariables(cmd.getVariables());

    return cmd.isReturnWithVariables()
      ? ProcessInstanceMapper.processInstanceDto(builder.executeWithVariablesInReturn())
      : ProcessInstanceMapper.processInstanceDto(builder.execute());
  }
}