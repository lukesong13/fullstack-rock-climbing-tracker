const express = require('express');
const path = require('path');
const app = express();
const port = process.env.PORT || 3000;

// Serve static files from the directory containing index.html
app.use(express.static(path.join(__dirname)));

app.listen(port, () => {
    console.log(`Server started. Available at http://localhost:${port}`);
});