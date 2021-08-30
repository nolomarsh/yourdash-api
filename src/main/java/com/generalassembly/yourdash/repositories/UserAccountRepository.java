package com.generalassembly.yourdash.repositories;

import org.springframework.data.repository.CrudRepository;

import com.generalassembly.yourdash.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount,Integer> {

}
