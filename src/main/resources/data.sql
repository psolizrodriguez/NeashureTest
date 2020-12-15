INSERT INTO `address`(`address_id`,`street`,`city`,`state`) VALUES (1,'street','city','state');

INSERT INTO `contact`
(`contact_id`,
`birthdate`,
`company`,
`email`,
`name`,
`personal_phone_number`,
`profile_image`,
`work_phone_number`,
`address_address_id`)
VALUES
(1,
null,
'',
'uriely@hotmail.com',
'Uriel',
'5549897889',
'',
'5549897889',
1);

INSERT INTO `movie` (`movie_id`,`movie`) VALUES (1, 'Toy Story');
INSERT INTO `movie` (`movie_id`,`movie`) VALUES (2, 'Star Wars');
INSERT INTO `contact_movie` (`contact_id`,`movie_id`, `observations`, `score`) VALUES (1, 1, 'observations', 3);
INSERT INTO `contact_movie` (`contact_id`,`movie_id`, `observations`, `score`) VALUES (1, 2, 'observations', 4);