-- Document Types
INSERT INTO document_type (id, name, tenant) VALUES
(1, 'Passport', 'SG'),
(2, 'Address Proof', 'SG'),
(3, 'Tax Declaration Form', 'HK'),
(4, 'Residential Address Change', 'SG'),
(5, 'Bank Account Declaration', 'HK');

-- Metadata Questions
INSERT INTO document_type_metadata (id, document_type_id, question_key, question_label) VALUES
(1, 1, 'passportNumber', 'Passport Number'),
(2, 1, 'issueDate', 'Date of Issue'),
(3, 1, 'expiryDate', 'Date of Expiry'),
(4, 1, 'issuingCountry', 'Issuing Country'),
(5, 2, 'addressType', 'Type of Address'),
(6, 2, 'fullAddress', 'Full Address'),
(7, 2, 'issueDate', 'Issue Date');

-- Workflows
INSERT INTO workflow (workflow_id, user_id, tenant, document_type, status) VALUES
('WRKFLW_user01_13062025_133045', 'user01', 'SG', 'Passport', 'SUBMITTED');

-- Metadata (no FK constraint issues here, relies on JPA relationships)
INSERT INTO workflow_metadata (id, workflow_id, metadata_key, metadata_value) VALUES
(1, 'WRKFLW_user01_13062025_133045', 'passportNumber', 'X1234567'),
(2, 'WRKFLW_user01_13062025_133045', 'issueDate', '2024-01-01'),
(3, 'WRKFLW_user01_13062025_133045', 'expiryDate', '2034-01-01'),
(4, 'WRKFLW_user01_13062025_133045', 'issuingCountry', 'Singapore');