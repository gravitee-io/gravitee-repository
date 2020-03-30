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
package io.gravitee.repository.management.api;

import io.gravitee.repository.exceptions.TechnicalException;
import io.gravitee.repository.management.model.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Nicolas GERAUD (nicolas.geraud at graviteesource.com)
 * @author GraviteeSource Team
 */
public interface MembershipRepository {

    Membership create(Membership membership) throws TechnicalException;
    Membership update(Membership membership) throws TechnicalException;
    void delete(Membership membership) throws TechnicalException;

    /**
     * delete all members of a reference
     * @param referenceType
     * @param referenceId
     * @throws TechnicalException
     */
    void deleteMembers(MembershipReferenceType referenceType, String referenceId) throws TechnicalException;

    /**
     * find membership by id.
     * the MembershipId is a combination of username, reference type and referenceId
     * => a user has only one membership for a given reference
     * @param userId the user
     * @param referenceType the reference type
     * @param referenceId the reference id
     * @return an optional membership
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Optional<Membership> findById(String userId, MembershipReferenceType referenceType, String referenceId) throws TechnicalException;


    /**
     * find membership by ids.
     * the MembershipId is a combination of username, reference type and referenceId
     * => a user has only one membership for a given reference
     * @param userId the user
     * @param referenceType the reference type
     * @param referenceIds the reference ids
     * @return an optional membership
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Set<Membership> findByIds(String userId, MembershipReferenceType referenceType, Set<String> referenceIds) throws TechnicalException;

    /**
     * find all memberships for a specific reference
     * => find all members of an api
     * @param referenceType the reference type
     * @param referenceId the reference id
     * @param roleScope the roleScope, could be null
     * @param roleName the roleName, could be null
     * @return the list of memberships, or an empty set
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Set<Membership> findByReferenceAndRole(MembershipReferenceType referenceType, String referenceId, RoleScope roleScope, String roleName) throws TechnicalException;

    /**
     * find all memberships for a specific reference
     * => find all primary owner of a list of apis
     * @param referenceType the reference type
     * @param referenceIds the reference ids
     * @param roleScope the roleScope, could be null
     * @param roleName the roleName, could be null
     * @return the list of memberships, or an empty set
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Set<Membership> findByReferencesAndRole (MembershipReferenceType referenceType, List<String> referenceIds, RoleScope roleScope, String roleName) throws TechnicalException;

    /**
     * find all memberships for a user and a referenceType
     * => find all apis of a user
     * @param userId the user
     * @param referenceType the referenceType
     * @return the list of memberships, or an empty set
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Set<Membership> findByUserAndReferenceType(String userId, MembershipReferenceType referenceType) throws TechnicalException;

    /**
     * find all memberships for a role
     * @param roleScope the role
     * @param roleName the role
     * @return the list of memberships, or an empty set
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Set<Membership> findByRole(RoleScope roleScope, String roleName) throws TechnicalException;

    /**
     * find all memberships for a user, a referenceType and a membership type
     * => find all apis of a user where he is a primary owner
     * @param userId the user
     * @param referenceType the referenceType
     * @param roleScope the roleScope, could be null
     * @param roleName the roleName, could be null
     * @return the list of memberships, or an empty set
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Set<Membership> findByUserAndReferenceTypeAndRole(String userId, MembershipReferenceType referenceType, RoleScope roleScope, String roleName) throws TechnicalException;

    /**
     * find all memberships for a user
     * @param userId the user
     * @return the list of memberships, or an empty set
     * @throws TechnicalException if something goes wrong, should never happen.
     */
    Set<Membership> findByUser(String userId) throws TechnicalException;
}