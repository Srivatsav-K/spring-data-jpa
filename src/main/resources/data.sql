SELECT NOW();

INSERT INTO patients (
    patient_name,
    birth_date,
    email,
    gender,
    blood_group,
    created_at,
    updated_at
) VALUES
(
    'Alice Johnson',
    '1990-05-15',
    'alice.johnson@example.com',
    'Female',
    'A_POSITIVE',
    '2025-12-10 10:00:00+00',
    '2025-12-10 10:00:00+00'
),
(
    'Robert Smith',
    '1985-11-20',
    'robert.smith@example.com',
    'Male',
    'O_NEGATIVE',
    '2025-12-10 10:00:00+00',
    '2025-12-10 10:00:00+00'
),
(
    'Emily Davis',
    '2001-03-01',
    'emily.davis@example.com',
    'Female',
    'B_POSITIVE',
    '2025-12-10 10:01:00+00',
    '2025-12-10 10:01:00+00'
),
(
    'Michael Brown',
    '1976-08-25',
    'michael.brown@example.com',
    'Male',
    'AB_POSITIVE',
    '2025-12-10 10:01:00+00',
    '2025-12-10 10:01:00+00'
),
(
    'Sarah Wilson',
    '1998-01-10',
    'sarah.wilson@example.com',
    'Female',
    'O_POSITIVE',
    '2025-12-10 10:02:00+00',
    '2025-12-10 10:02:00+00'
),
(
    'David Miller',
    '1965-07-30',
    'david.miller@example.com',
    'Male',
    'A_NEGATIVE',
    '2025-12-10 10:02:00+00',
    '2025-12-10 10:02:00+00'
),
(
    'Jennifer Garcia',
    '1993-04-12',
    'jennifer.garcia@example.com',
    'Female',
    'B_POSITIVE',
    '2025-12-10 10:03:00+00',
    '2025-12-10 10:03:00+00'
),
(
    'James Rodriguez',
    '1980-09-03',
    'james.rodriguez@example.com',
    'Male',
    'O_POSITIVE',
    '2025-12-10 10:03:00+00',
    '2025-12-10 10:03:00+00'
),
(
    'Jessica Martinez',
    '1999-06-18',
    'jessica.martinez@example.com',
    'Female',
    'AB_NEGATIVE',
    '2025-12-10 10:04:00+00',
    '2025-12-10 10:04:00+00'
),
(
    'Christopher Hernandez',
    '1972-12-05',
    'christopher.hernandez@example.com',
    'Male',
    'A_POSITIVE',
    '2025-12-10 10:04:00+00',
    '2025-12-10 10:04:00+00'
);