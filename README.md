# MCP Server (STDIO)

## Overview

This project implements an **MCP Server using STDIO** transport.

It is designed to work with an MCP client (for example, a Spring AI–based MCP client) and exposes a set of MCP tools/functions over standard input/output.

## Transport

- **STDIO (Standard Input / Output)**

This mode is typically used for:
- Local development
- CLI-based integrations
- Direct process-to-process communication

## Verifying Server Functions

All functions (tools) exposed by this MCP server can be **verified and tested using the MCP Inspector**.

### MCP Inspector

The MCP Inspector allows you to:
- Discover available tools
- Inspect input/output schemas
- Invoke tools manually
- View requests and responses interactively

#### Prerequisites

- **Node.js must be installed**

#### Run MCP Inspector

```bash
npx @modelcontextprotocol/inspector
```

>  Screenshots demonstrating tool discovery and invocation using MCP Inspector are available.

## Logging

- `SimpleLoggerAdvisor` is enabled to provide **basic logging** for:
    - Incoming requests
    - Outgoing responses

This is useful for debugging and understanding MCP interactions.

## Notes

- Ensure the server is running before connecting via an MCP client or Inspector.
- STDIO transport is best suited for local and embedded use cases.
