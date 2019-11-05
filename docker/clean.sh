echo "removing containers"
docker rm docker_discovery_1
docker rm docker_zuul_1
docker rm docker_product_1
docker rm docker_wishlist_1
docker rm docker_cart_1
docker rm docker_support_1
docker rm docker_mysql-container_1

echo "removing images"
docker rmi docker_discovery
docker rmi docker_zuul
docker rmi docker_product
docker rmi docker_wishlist
docker rmi docker_cart
docker rmi docker_support
docker rmi docker_mysql-container

