(ns reviews-next.core
  (:require [reagent.dom :as rdom]
            [re-frame.core :as re-frame]
            [reviews-next.events :as events]
            [reviews-next.pages.login :as login]
            [reviews-next.pages.review-event :as review-event]
            [reviews-next.pages.feedback-event :as feedback-event]))


(defn app []
  [:div
   ; [review-event/review-event]
   [feedback-event/feedback-event]])

(defn init! []
  (re-frame/dispatch [:initialize-db])
  (re-frame/dispatch-sync [:setup-google-signin-functions])
  (rdom/render [app] (.getElementById js/document "app")))
