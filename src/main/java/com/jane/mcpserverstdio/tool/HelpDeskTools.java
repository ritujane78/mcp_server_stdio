package com.jane.mcpserverstdio.tool;


import com.jane.mcpserverstdio.entity.HelpDeskTicket;
import com.jane.mcpserverstdio.model.TicketRequest;
import com.jane.mcpserverstdio.service.HelpDeskTicketService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HelpDeskTools {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelpDeskTools.class);

    private final HelpDeskTicketService service;

    @Tool(name = "createTicket", description = "Create the Support Ticket")
    String createTicket(
            @ToolParam(description = "Username of the user") String username,
            @ToolParam(description = "Issue description") String issue
    ) {
        LOGGER.info("Creating support ticket for user: {} with issue: {}", username, issue);

        TicketRequest ticketRequest = new TicketRequest(username, issue);
        HelpDeskTicket savedTicket = service.createTicket(ticketRequest);

        return "Ticket #" + savedTicket.getId()
                + " created successfully for user " + savedTicket.getUsername();
    }


    @Tool(name="getTicketStatus", description = "Fetch the status of the tickets based on a given username")
    List<HelpDeskTicket> getTicketStatus(@ToolParam(description =
            "Username to fetch the status of the help desk tickets") String username) {
        LOGGER.info("Fetching tickets for user: {}", username);
        List<HelpDeskTicket> tickets =  service.getTicketsByUsername(username);
        LOGGER.info("Found {} tickets for user: {}", tickets.size(), username);
        return tickets;
    }

}
