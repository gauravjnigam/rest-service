package com.gn.restsvc.GnRestSvc.user.contoller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gn.restsvc.GnRestSvc.user.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
