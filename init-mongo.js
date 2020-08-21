db = db.getSiblingDB('the1');
db.createUser(
    {
        user: "admin",
        pwd: "admin",
        roles: [
            {
                role: "readWrite",
                db: "the1"
            }
        ]
    }
);
db.createCollection('users');