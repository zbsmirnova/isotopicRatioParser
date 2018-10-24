DELETE FROM isotopic_pb_samples;
DELETE FROM concentration_pb_samples;
DELETE FROM rb_samples;
DELETE FROM u_samples;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO isotopic_pb_samples (sampleName, date, ratio206204, err206204, ratio206207, err206207, ratio206208, err206208) VALUES
  --100000
  ('firstPb', '2015-05-29', 106.104, 0.164, 106.107, 0.167, 106.108, 0.168),
  --100001
  ('secondPb', '2015-05-30', 206.204, 0.264, 206.207, 0.267, 206.208, 0.268),
  --100003
  ('thirdPb', '2015-05-31', 306.304, 0.364, 306.307, 0.367, 306.308, 0.368);

INSERT INTO concentration_pb_samples (sampleName, date, ratio206207, err206207, ratio206208, err206208) VALUES
  --100004
  ('firstPb', '2015-04-29', 156.157, 0.167, 156.158, 0.168),
  --100005
  ('secondPb', '2015-04-30', 256.257, 0.267, 256.258, 0.268),
  --100006
  ('thirdPb', '2015-04-30',356.357, 0.367, 356.358, 0.368);


INSERT INTO rb_samples (SAMPLENAME, DATE, RATIO8587, ERR8587) values
----100007
  ('firstRb', '2015-04-29', 185.187, 0.187),
----100008
  ('secondRb', '2015-04-30', 285.287, 0.287),
----100009
  ('thirdRb', '2015-04-30', 385.387, 0.387);

INSERT INTO U_SAMPLES (sampleName, date, ratio238235, err238235) VALUES
----100010
  ('firstU', '2015-05-30', 138.135, 0.135),
----100011
  ('secondU', '2015-05-30', 338.335, 0.335),
----100012
  ('thirdU', '2015-05-30', 338.335, 0.335);


