package com.example.app.repository;
import com.example.app.model.Board;
import com.example.app.model.BoardItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BoardItemRepository extends JpaRepository<BoardItem, Long> { List<BoardItem> findByBoardOrderByDueDateAsc(Board board); }
