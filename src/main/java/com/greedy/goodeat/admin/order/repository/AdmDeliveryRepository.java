package com.greedy.goodeat.admin.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.dto.DeliveryDTO;
import com.greedy.goodeat.common.entity.Delivery;

public interface AdmDeliveryRepository extends JpaRepository<Delivery, Integer>{



}
