/*
 * Copyright (C) 2015 hops.io.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.hops.metadata.yarn.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;
import io.hops.metadata.yarn.entity.ContainerStatus;

import java.util.Collection;
import java.util.Map;

public interface ContainerStatusDataAccess<T> extends EntityDataAccess {

  /**
   * Find by ContainerId and RNodeId
   * <p/>
   *
   * @param containerId
   * @param rmNodeId
   * @return
   * @throws io.hops.exception.StorageException
   */
  T findEntry(String containerId, String rmNodeId, String type)
          throws StorageException;

  Map<String, ContainerStatus> getAll() throws StorageException;

  void addAll(Collection<T> containerStatus) throws StorageException;

  void removeAll(Collection<T> containerStatus) throws StorageException;
}
