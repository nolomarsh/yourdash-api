package com.generalassembly.yourdash.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.generalassembly.yourdash.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount,Integer> {

    public List<UserAccount> findUserAccountByUsername(String username);
}
