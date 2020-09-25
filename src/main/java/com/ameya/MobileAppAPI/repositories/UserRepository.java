package com.ameya.MobileAppAPI.repositories;

import com.ameya.MobileAppAPI.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * This function returns a single user whose email matches
     * with the email provided here as parameter. This function works under the assumption
     * that email id is unique for each account.
     *
     * Note : I have used "Optional" here because the findUserByEmail returns null if
     * the user is not found. This is default implementation of MongoRepository.
     * So instead of dealing with Null which can lead to unexpected NullPointerException
     * we use "Optional". In general it seems a better practice to use "Optional"
     *
     * @param email
     * @return Optional<User>
     */
    Optional<User> findUserByEmail(final String email);
    List<User> deleteUserByEmail(final String email);
}
