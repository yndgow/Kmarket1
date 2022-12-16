SELECT COUNT(`qnaNo`) FROM `km_cs_qna`;
SELECT a.*, b.`nick` FROM `km_cs_qna` AS a 
JOIN `km_member` AS b ON a.uid = b.uid 
ORDER BY `qnaNo` DESC 
LIMIT 1, 10;

/* 더미 데이터 생성 로직 */
INSERT INTO `km_cs_qna`(`qc1Name`,`qc2Name`,`uid`,`wdate`,`qnatitle`,`qnaContent`,`regip`)(SELECT `qc1Name`,`qc2Name`, `uid`, `wdate`,`qnatitle`,`qnaContent`,`regip` FROM `km_cs_qna`);