package com.greedy.goodeat.admin.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.admin.inquiry.entity.Reply;

public interface AdmReplyRepository extends JpaRepository<Reply, Integer>{

	List<Reply> findByRefInquiryNo(Integer refInquiryNo);

	Reply findByReplyNo(Integer replyNo);

}
