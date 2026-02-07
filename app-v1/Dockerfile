FROM node:18-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .

FROM node:18-alpine AS production
WORKDIR /app
COPY --from=build /app ./
RUN npm ci --only=production
EXPOSE 3000
# CMD ["node", "server.js"]
CMD ["node", "index.js"]
