(ns hello-mcp-clj.client.roots
  (:require
   [plumcp.core.api.cap :as cap]))


(def root-customer-records
  "Client root for customer records"
  (cap/make-root-item "root://customer-records"))


(def root-finance-documents
  "Client root for finance documents"
  (cap/make-root-item "root://finance-documents"))


(def root-annual-report-2026
  "Client root for annual reports 2026 edition"
  (cap/make-root-item "root://annual-report"))
