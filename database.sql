CREATE DATABASE ReaderDB;

CREATE TABLE `ReaderDB`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `ReaderDB`.`Books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `genre` VARCHAR(45) NULL,
  `price` DECIMAL(12,2) NOT NULL,
  `filepath` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `ReaderDB`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `total` DECIMAL(12,2) NOT NULL,
  `order_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `Orders_Users`
    FOREIGN KEY (`user_id`)
    REFERENCES `ReaderDB`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `ReaderDB`.`OrderItems` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Items_Orders_idx` (`order_id` ASC),
  INDEX `Items_Books_idx` (`book_id` ASC),
  CONSTRAINT `Items_Orders`
    FOREIGN KEY (`order_id`)
    REFERENCES `ReaderDB`.`Orders` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Items_Books`
    FOREIGN KEY (`book_id`)
    REFERENCES `ReaderDB`.`Books` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `ReaderDB`.`Deliveries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `purchase_code` VARCHAR(45) NOT NULL,
  `user_id` INT NULL,
  `book_id` INT NULL,
  `item_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `Deliveries_Books_idx` (`book_id` ASC),
  INDEX `Deliveries_Users_idx` (`user_id` ASC),
  INDEX `Deliveries_Items_idx` (`item_id` ASC),
  CONSTRAINT `Deliveries_Books`
    FOREIGN KEY (`book_id`)
    REFERENCES `ReaderDB`.`Books` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Deliveries_Users`
    FOREIGN KEY (`user_id`)
    REFERENCES `ReaderDB`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Deliveries_Items`
    FOREIGN KEY (`item_id`)
    REFERENCES `ReaderDB`.`OrderItems` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `ReaderDB`.`WishLists` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `book_id` INT NULL,
  `wish_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Wish_Users_idx` (`user_id` ASC),
  INDEX `Wish_Books_idx` (`book_id` ASC),
  CONSTRAINT `Wish_Users`
    FOREIGN KEY (`user_id`)
    REFERENCES `ReaderDB`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Wish_Books`
    FOREIGN KEY (`book_id`)
    REFERENCES `ReaderDB`.`Books` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `ReaderDB`.`Posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NULL,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Posts_Users_idx` (`user_id` ASC),
  CONSTRAINT `Posts_Users`
    FOREIGN KEY (`user_id`)
    REFERENCES `ReaderDB`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `ReaderDB`.`Comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `post_id` INT NULL,
  `content` VARCHAR(500) NULL,
  `time` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `Comments_Users_idx` (`user_id` ASC),
  INDEX `Comments_Posts_idx` (`post_id` ASC),
  CONSTRAINT `Comments_Users`
    FOREIGN KEY (`user_id`)
    REFERENCES `ReaderDB`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Comments_Posts`
    FOREIGN KEY (`post_id`)
    REFERENCES `ReaderDB`.`Posts` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
