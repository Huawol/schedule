USE schedule;

CREATE TABLE schedule
(
    id       BIGINT       AUTO_INCREMENT PRIMARY KEY COMMENT '메모 식별자',
    title    VARCHAR(100) NOT NULL COMMENT '제목',
    contents TEXT COMMENT '내용',
    author VARCHAR(50) NOT NULL COMMENT '이름',
    password VARCHAR(255) NOT NULL COMMENT '비번',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DELETE from schedule

ALTER TABLE schedule AUTO_INCREMENT = 1; /* 삭제하고 나서 쓰기*/