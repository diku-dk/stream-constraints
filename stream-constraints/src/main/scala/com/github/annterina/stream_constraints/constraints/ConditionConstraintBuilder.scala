package com.github.annterina.stream_constraints.constraints

import org.apache.kafka.common.serialization.Serde

class ConditionConstraintBuilder[K, V, L](constraint: Constraint[K, V, L]) {

  def link(f: (K, V) => L)(implicit serde: Serde[L]): ConditionConstraintBuilder[K, V, L] = {
    new ConditionConstraintBuilder[K, V, L](constraint.withLink(f, serde))
  }

  // TODO additional filtering
  def where(f: (K, V) => Any) = ???

  def build(keySerde: Serde[K], valueSerde: Serde[V]): Constraint[K, V, L] = {
    constraint.withKeySerde(keySerde).withValueSerde(valueSerde)
  }

}

