/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.server.controller.internal;

import org.apache.commons.lang.StringUtils;

/**
 * AmbariServerConfigurationCategory is an enumeration of the different Ambari server specific
 * configuration categories.
 */
public enum AmbariServerConfigurationCategory {
  LDAP_CONFIGURATION("ldap-configuration");

  private final String categoryName;

  AmbariServerConfigurationCategory(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  /**
   * Safely returns an {@link AmbariServerConfigurationCategory} given the category's descriptive name
   *
   * @param categoryName a descriptive name
   * @return an {@link AmbariServerConfigurationCategory}
   */
  public static AmbariServerConfigurationCategory translate(String categoryName) {
    if (!StringUtils.isEmpty(categoryName)) {
      categoryName = categoryName.trim();
      for (AmbariServerConfigurationCategory category : values()) {
        if (category.getCategoryName().equals(categoryName)) {
          return category;
        }
      }
    }

    throw new IllegalArgumentException(String.format("Invalid Ambari server configuration category name: %s", categoryName));
  }

  /**
   * Safely returns the {@link AmbariServerConfigurationCategory}'s descriptive name or <code>null</code>
   * if no {@link AmbariServerConfigurationCategory} was supplied.
   *
   * @param category an {@link AmbariServerConfigurationCategory}
   * @return the descriptive name of an {@link AmbariServerConfigurationCategory}
   */
  public static String translate(AmbariServerConfigurationCategory category) {
    return (category == null) ? null : category.getCategoryName();
  }
}
