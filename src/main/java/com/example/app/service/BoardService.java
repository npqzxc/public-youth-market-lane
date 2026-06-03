package com.example.app.service;
import com.example.app.model.Board;
import com.example.app.model.BoardItem;
import com.example.app.repository.BoardItemRepository;
import com.example.app.repository.BoardRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
@Service
public class BoardService { private final BoardRepository boards; private final BoardItemRepository items; public BoardService(BoardRepository boards, BoardItemRepository items){this.boards=boards;this.items=items;} public List<Board> listBoards(){ return boards.findAll(); } public Map<String,Object> getBoardDetail(String code){ var board = boards.findByCode(code); if(board.isEmpty()) return null; var payload = new HashMap<String,Object>(); payload.put("board", board.get()); payload.put("items", items.findByBoardOrderByDueDateAsc(board.get())); return payload; } public void createItem(String code,String title,String stage,String priority,String dueDate,String details){ var board = boards.findByCode(code).orElseThrow(); var item = new BoardItem(); item.setBoard(board); item.setTitle(title); item.setStage(stage); item.setPriority(priority); item.setDueDate(dueDate); item.setDetails(details); items.save(item);} }
