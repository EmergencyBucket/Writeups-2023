FROM node:16-alpine

COPY package*.json ./

RUN npm install

COPY . .

ENV API_PORT=80

ENV SECRET='s3cret'

ENV HINT="check the /validate route; use token as the query param"

ENV FLAG="bucket{1_l0v3_jwt!!!1!!!!1!!!!!1111!}"

EXPOSE 80

CMD ["node", "main.js"]