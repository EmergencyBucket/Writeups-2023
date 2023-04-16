FROM php:apache

COPY flag.txt /flag.txt
COPY src/ /var/www/html/
RUN chown -R www-data:www-data /var/www

EXPOSE 80