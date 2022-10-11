package com.greedy.goodeat.admin.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greedy.goodeat.common.entity.Post;

public interface AdmEventRepository extends JpaRepository<Post, Integer> {

	@Query("SELECT p " +
			 "FROM Post p " +
			"WHERE (p.postTitle LIKE '%' || :searchValue || '%' " +
			   "OR p.postContent LIKE '%' || :searchValue || '%')")
	Page<Post> findBySearchValue(@Param("searchValue") String searchValue, Pageable pageable);

}
