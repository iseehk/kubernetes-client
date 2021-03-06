/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.policy.DoneablePodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.DoneablePodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.PodDisruptionBudgetList;
import io.fabric8.kubernetes.api.model.policy.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.PolicyAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.policy.v1beta1.PodDisruptionBudgetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PodSecurityPolicyOperationsImpl;
import okhttp3.OkHttpClient;

public class PolicyAPIGroupClient extends BaseClient implements PolicyAPIGroupDSL {

  public PolicyAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<PodSecurityPolicy, PodSecurityPolicyList, DoneablePodSecurityPolicy, Resource<PodSecurityPolicy, DoneablePodSecurityPolicy>> podSecurityPolicies() {
    return new PodSecurityPolicyOperationsImpl(httpClient, getConfiguration());
  }

  @Override
  public MixedOperation<PodDisruptionBudget, PodDisruptionBudgetList, DoneablePodDisruptionBudget, Resource<PodDisruptionBudget, DoneablePodDisruptionBudget>> podDisruptionBudget() {
    return new PodDisruptionBudgetOperationsImpl(httpClient, getConfiguration());
  }
}
