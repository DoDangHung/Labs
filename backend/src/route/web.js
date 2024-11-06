/** @format */

import express from "express";
import homeControllers from "../controller/homeControllers";

let router = express.Router();

let initWebRoutes = (app) => {
  router.get("/about", homeControllers.getHomePage);

  return app.use("/", router);
};

module.exports = initWebRoutes;
