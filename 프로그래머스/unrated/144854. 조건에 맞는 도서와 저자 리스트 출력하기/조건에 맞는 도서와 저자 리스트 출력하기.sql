# SELECT b.book_id, a.author_name, SUBSTRING(b.published_date, 1, 10) as published_date
# FROM author a, book b
# WHERE b.category='경제'
# ORDER BY b.published_date
# ;

SELECT A.BOOK_ID, B.AUTHOR_NAME, DATE_FORMAT(A.PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK A JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE category = '경제'
ORDER BY PUBLISHED_DATE