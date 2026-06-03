package com.example.app.config;
import com.example.app.model.Board;
import com.example.app.repository.BoardRepository;
import com.example.app.service.BoardService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
@Component
public class SeedDataLoader { private final BoardRepository boards; private final BoardService service; public SeedDataLoader(BoardRepository boards, BoardService service){this.boards=boards;this.service=service;} @PostConstruct public void load(){ if(boards.count()>0) return; Board north=new Board(); north.setCode("NORTH"); north.setName("North 摊位分区"); north.setSummary("负责核心校园市集的日常计划和协同。"); north.setStatus("active"); north.setOwner("luca"); boards.save(north); Board south=new Board(); south.setCode("SOUTH"); south.setName("South 摊位分区"); south.setSummary("处理外部依赖和延期问题。"); south.setStatus("review"); south.setOwner("riley"); boards.save(south); service.createItem("NORTH","Refresh weekly pack","draft","high","2026-06-06","重新整理每周同步包和排班说明。"); service.createItem("NORTH","Audit overdue slots","active","medium","2026-06-08","盘点超期事项并补齐 owner。"); service.createItem("SOUTH","Align handoff notes","review","high","2026-06-04","补齐 handoff note 和风险登记。"); } }
