/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
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
package io.gravitee.repository.management.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class User {
	public enum AuditEvent implements Audit.AuditEvent {
		USER_CREATED, USER_UPDATED, USER_CONNECTED, PASSWORD_RESET
	}

	/**
	 * User identifier
	 */
	private String id;

	/**
	 * The user name
	 */
	private String username;

	/**
	 * The source when user is coming from an external system (LDAP, ...)
	 */
	private String source;

	/**
	 * The user reference in the external source
	 */
	private String sourceId;

	/**
	 * The user password
	 */
	private String password;

	/**
	 * The user email
	 */
	private String email;

	/**
	 * The user first name
	 */
	private String firstname;

	/**
	 * The user last name
	 */
	private String lastname;

	/**
	 * The user creation date
	 */
	private Date createdAt;

	/**
	 * The user last updated date
	 */
	private Date updatedAt;

	/**
	 * The user last connection date
	 */
	private Date lastConnectionAt;

	/**
	 * The user picture
	 */
	private String picture;

	public User() {}

	public User(User cloned) {
		this.id = cloned.id;
		this.username = cloned.username;
		this.source = cloned.source;
		this.sourceId = cloned.sourceId;
		this.password = cloned.password;
		this.email = cloned.email;
		this.firstname = cloned.firstname;
		this.lastname = cloned.lastname;
		this.createdAt = cloned.createdAt;
		this.updatedAt = cloned.updatedAt;
		this.lastConnectionAt = cloned.lastConnectionAt;
		this.picture = cloned.picture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Date getLastConnectionAt() {
		return lastConnectionAt;
	}

	public void setLastConnectionAt(Date lastConnectionAt) {
		this.lastConnectionAt = lastConnectionAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("id='").append(id).append('\'');
		sb.append(", username='").append(username).append('\'');
		sb.append(", source='").append(source).append('\'');
		sb.append(", external_reference='").append(sourceId).append('\'');
		sb.append(", firstname='").append(firstname).append('\'');
		sb.append(", lastname='").append(lastname).append('\'');
		sb.append(", mail='").append(email).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
