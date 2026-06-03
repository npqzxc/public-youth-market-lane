package com.example.app.service;
import com.example.app.repository.BoardItemRepository;
import com.example.app.repository.BoardRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
@Service
public class DashboardService { private final BoardRepository boards; private final BoardItemRepository items; public DashboardService(BoardRepository boards, BoardItemRepository items){this.boards=boards;this.items=items;} public Map<String,Object> summary(){ Map<String,Object> payload=new LinkedHashMap<>(); payload.put("boardTotal", boards.count()); payload.put("itemTotal", items.count()); payload.put("message", "Dashboard payload shared by page and API"); return payload; } }
