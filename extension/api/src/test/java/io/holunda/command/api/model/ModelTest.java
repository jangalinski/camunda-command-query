package io.holunda.command.api.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;
import org.junit.Test;

public class ModelTest {

  @Test
  public void businessKey() {
    assertThat(BusinessKey.of("1").value()).isEqualTo("1");

    assertThatThrownBy(() -> BusinessKey.of("   "))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("null or empty");
  }

  @Test
  public void businessKey_random() {
    BusinessKey random = BusinessKey.random();
    assertThat(UUID.fromString(random.value())).isNotNull();
  }
}
