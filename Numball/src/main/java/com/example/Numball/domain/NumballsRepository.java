package com.example.Numball.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// DAO : DB Layer 접근자.
public interface NumballsRepository extends JpaRepository<Numballs, Long> {
}
