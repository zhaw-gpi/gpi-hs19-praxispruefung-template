package ch.zhaw.iwi.gpi.twitter;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TweetRepository
 */
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    
}