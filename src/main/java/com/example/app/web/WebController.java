package com.example.app.web;
import com.example.app.service.BoardService;
import com.example.app.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class WebController { private final DashboardService dashboard; private final BoardService boards; public WebController(DashboardService dashboard, BoardService boards){this.dashboard=dashboard;this.boards=boards;} @GetMapping("/") public String dashboard(Model model){ model.addAttribute("summary", dashboard.summary()); return "dashboard"; } @GetMapping("/boards") public String boards(Model model){ model.addAttribute("boards", boards.listBoards()); return "boards"; } @GetMapping("/boards/{code}") public String boardDetail(@PathVariable String code, Model model){ model.addAttribute("detail", boards.getBoardDetail(code)); return "board-detail"; } @GetMapping("/items/new") public String newItem(){ return "new-item"; } @PostMapping("/items") public String createItem(@RequestParam String code,@RequestParam String title,@RequestParam String stage,@RequestParam String priority,@RequestParam String dueDate,@RequestParam String details){ boards.createItem(code,title,stage,priority,dueDate,details); return "redirect:/boards/" + code; } }
