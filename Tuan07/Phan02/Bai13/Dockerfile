# Build stage
FROM node:18 as build
WORKDIR /app
COPY react-app/ .
RUN npm install
RUN npm run build

# Serve stage
FROM nginx:alpine
COPY nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
