package com.example.app.web;
import com.example.app.service.BoardService;
import com.example.app.service.DashboardService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class ApiController { private final DashboardService dashboard; private final BoardService boards; public ApiController(DashboardService dashboard, BoardService boards){this.dashboard=dashboard;this.boards=boards;} @GetMapping("/dashboard") public Object dashboard(){ return dashboard.summary(); } @GetMapping("/boards") public Object boards(){ return boards.listBoards(); } @GetMapping("/boards/{code}") public Object boardDetail(@PathVariable String code){ return boards.getBoardDetail(code); } }
