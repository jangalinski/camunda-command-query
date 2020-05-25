package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.TopicName;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.lib.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _TopicName extends NonEmptyStringValueWrapper implements TopicName {
  // empty generator template
}
