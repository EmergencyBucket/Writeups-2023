const http = require("http");
const express = require("express");
require("dotenv").config();
const { API_PORT } = process.env;
const port = process.env.PORT || API_PORT;
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");

let app = express();

let users = {
  admin: process.env.SECRET,
};

const createUser = (username, password) => {
  const salt = bcrypt.genSaltSync(10);
  const hash = bcrypt.hashSync(password, salt);
  if (users[username]) {
    return false;
  }
  users[username] = hash;
  return true;
};

const validateUser = (username, password) => {
  const hash = users[username];
  if (!hash) {
    return false;
  }
  return bcrypt.compareSync(password, hash);
};

const issueToken = (username) => {
  const payload = {
    username: username,
  };
  return jwt.sign(payload, process.env.SECRET);
};

const validateToken = (token) => {
  try {
    const decoded = jwt.decode(token);
    const username = decoded.username;
    console.log(username);
    if (!username) {
      return false;
    }
    if (Object.keys(users).indexOf(username) === -1) {
      return false;
    }
    console.log("validated");
    return [true, username];
  } catch (e) {
    return false;
  }
};

app.use(express.json());

const httpBasicMiddleware = (req, res, next) => {
  const authHeader = req.headers.authorization;
  if (!authHeader) {
    res.set("WWW-Authenticate", 'Basic realm="Authorization Required"');
    res.status(401).send("No authorization header");
    return;
  }
  const [type, credentials] = authHeader.split(" ");
  if (type !== "Basic") {
    res.status(401).send("Wrong authorization type");
    return;
  }
  const [username, password] = Buffer.from(credentials, "base64")
    .toString()
    .split(":");
  if (!validateUser(username, password)) {
    res
      .status(401)
      .send(
        "Wrong username or password; register using /register and the username and password params"
      );
    return;
  }
  // add username to request
  req.username = username;
  next();
};

let permissions = {
  admin: "all",
};

app.get("/", httpBasicMiddleware, (req, res) => {
  res.set("Info", "check /info");
  let token = issueToken(req.username);
  // set in cookie
  res.cookie("token", token, { httpOnly: true });
  res.send("200 OK");
});
app.get("/register", (req, res) => {
  const { username, password } = req.query;
  if (createUser(username, password)) {
    permissions[username] = "none";
    res.send("User created");
  } else {
    res.status(400).send("User already exists");
  }
});
app.get("/validate", (req, res) => {
  const { token } = req.query;
  console.log(permissions);

  if (validateToken(token)[0]) {
    if (permissions[validateToken(token)[1]] != "all") {
      return res
        .status(400)
        .send("only the admin account has permissions to access the flag");
    }
    return res.send(process.env.FLAG);
  }
  return res.status(400).send("Token is invalid");
});
app.get("/info", httpBasicMiddleware, (req, res) => {
  res.send(process.env.HINT);
});
// server listening
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
