package com.greedy.goodeat.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Member;

public interface PaymentRepository extends JpaRepository<Member, Integer> {

	Member findById(int memberNo);

}
