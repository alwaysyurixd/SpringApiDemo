package com.exampleyuri.demo.Repository;

import com.exampleyuri.demo.Model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}