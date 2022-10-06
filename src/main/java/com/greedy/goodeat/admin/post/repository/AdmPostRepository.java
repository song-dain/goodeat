package com.greedy.goodeat.admin.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Post;


public interface AdmPostRepository extends JpaRepository<Post, Integer> {

}
