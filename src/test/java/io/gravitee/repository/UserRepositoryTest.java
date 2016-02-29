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
package io.gravitee.repository;

import io.gravitee.repository.config.AbstractRepositoryTest;
import io.gravitee.repository.management.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

public class UserRepositoryTest extends AbstractRepositoryTest {

    @Override
    protected String getTestCasesPath() {
        return "/data/user-tests/";
    }

    @Test
    public void createUserTest() throws Exception {
        String username = "createuser1";

        User user = new User();
        user.setUsername(username);
        user.setEmail(String.format("%s@gravitee.io", username));
        User userCreated = userRepository.create(user);

        Assert.assertNotNull("User created is null", userCreated);

        Optional<User> optional = userRepository.findByUsername(username);

        Assert.assertTrue("Unable to find saved user", optional.isPresent());
        User userFound = optional.get();

        Assert.assertEquals("Invalid saved user name.", user.getUsername(), userFound.getUsername());
        Assert.assertEquals("Invalid saved user mail.", user.getEmail(), userFound.getEmail());
    }

    @Test
    public void findAllTest() throws Exception {
        Set<User> users = userRepository.findAll();

        Assert.assertNotNull(users);
        Assert.assertEquals("Invalid user numbers in find all", 6, users.size());
    }
}
