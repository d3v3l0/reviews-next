(ns reviews-next.db.users
  (:require
          [clojure.pprint :as pp]
          [clojure.java.jdbc :refer :all]
          [reviews-next.config :as config]))

(def connection-uri-default (config/connection-uri))
(def connection-uri-test (config/connection-uri "test"))

(def data
  {:id "U4"
   :name "DEF"
   :email "def@gmail.com"})

(defn insert
  "execute query and return lazy sequence"
  ([data] (insert data connection-uri-default))
  ([data connection-uri]
   (try
        do
          (insert! connection-uri :users data)
          true
     (catch Exception e
       false))))

(defn delete-all
  ([] (delete-all connection-uri-default))
  ([connection-uri]
   (db-do-commands connection-uri "delete from users")))

(defn get-users
  ([] (get-users connection-uri-default))
  ([connection-uri]
   (try
      (query connection-uri ["select * from users"])
     (catch Exception e
      false))))
