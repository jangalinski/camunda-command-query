package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.TenantId;
import io.holunda.command.api.value.impl.ValueImplGenerator.StringValueWrapper;
import io.holunda.command.api.value.impl.ValueImplGenerator.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _TenantId extends StringValueWrapper implements TenantId {
  // empty generator template
}