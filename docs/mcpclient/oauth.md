---
icon: material/key-variant
---

# OAuth 2.1 for Streamable HTTP Transport

## CIMD Support

This requires PluMCP 0.3.0 or higher.

The MCP 2025-Nov-25 spec does not promote OAuth Dynamic Client Registration (DCR) as the default/preferred client registration mechanism anymore. It also supports Client ID Metadata Documents (CIMD) as a first class alternative to DCR. With version 0.3.0 uptake ECA may publish CIMD support as follows:

Publish a file `client.json` (or suitably named, e.g. `mcp-client.json`) on a website with the following content:

```json
{
  "client_id": "https://<your-website-host-fixme>.com/client.json",
  "client_name": "YourApp PluMCP Client",
  "redirect_uris": [
    "http://localhost:6277/"
  ],
  "grant_types": [
    "authorization_code"
  ],
  "response_types": [
    "code"
  ],
  "token_endpoint_auth_method": "none"
}
```

The `"redirect_uris"` entry above should match `:auth-options` config `:redirect-uris`, `:callback-redirect-uri` and `:callback-start-server`.

Then, in `:auth-options` map specify the following pointing to this URL.

```edn
{
  :client-id "https://.../client.json"
}
```

