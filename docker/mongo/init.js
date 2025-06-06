db = db.getSiblingDB('order_db');
db.createUser({
  user: "root",
  pwd: "mongo",
  roles: [{ role: "readWrite", db: "order_db" }]
});