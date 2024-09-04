--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-08-22 00:05:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 49385)
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- TOC entry 4813 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 49425)
-- Name: estoque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estoque (
    id uuid NOT NULL,
    nome_do_produto character varying(255) NOT NULL,
    serial_versionuid bigint DEFAULT 1 NOT NULL,
    tipo_do_produto character varying(255) NOT NULL,
    quantidade integer,
    filial character varying(255)
);


ALTER TABLE public.estoque OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 49336)
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 57535)
-- Name: registro_movimentação; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."registro_movimentação" (
    id_transacao uuid NOT NULL,
    data_entrada timestamp(6) without time zone,
    quantidade_recebida integer,
    regiao_entrada character varying(255),
    regiao_saida character varying(255),
    estoque_id uuid NOT NULL
);


ALTER TABLE public."registro_movimentação" OWNER TO postgres;

--
-- TOC entry 4806 (class 0 OID 49425)
-- Dependencies: 217
-- Data for Name: estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estoque (id, nome_do_produto, serial_versionuid, tipo_do_produto, quantidade, filial) FROM stdin;
be109513-2a0b-4a5c-95d3-bc09d5397c6d	Teclado Epomaker TH 80 se	1	Periférico	0	SP
1e810856-0cd1-4596-ab5f-6300e478348b	Teclado Mecânico	1	Eletrônicos	0	SP
2927676f-2490-42cc-9e4d-bd42251e569f	Cadeira de Escritório	1	Mobiliário	10	SP
\.


--
-- TOC entry 4805 (class 0 OID 49336)
-- Dependencies: 216
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
\.


--
-- TOC entry 4807 (class 0 OID 57535)
-- Dependencies: 218
-- Data for Name: registro_movimentação; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."registro_movimentação" (id_transacao, data_entrada, quantidade_recebida, regiao_entrada, regiao_saida, estoque_id) FROM stdin;
2e23832c-c066-4dd4-b537-804f46e6f04b	2024-08-17 14:00:00	50	Norte	Sul	1e810856-0cd1-4596-ab5f-6300e478348b
f96a0572-7f76-4906-8cf1-d5d53b609d79	2024-08-17 14:00:00	50	Sudeste	Sul	2927676f-2490-42cc-9e4d-bd42251e569f
\.


--
-- TOC entry 4658 (class 2606 OID 49431)
-- Name: estoque estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (id);


--
-- TOC entry 4655 (class 2606 OID 49343)
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- TOC entry 4660 (class 2606 OID 57541)
-- Name: registro_movimentação registro_movimentação_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."registro_movimentação"
    ADD CONSTRAINT "registro_movimentação_pkey" PRIMARY KEY (id_transacao);


--
-- TOC entry 4656 (class 1259 OID 49344)
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- TOC entry 4661 (class 2606 OID 57542)
-- Name: registro_movimentação fkr9pge4nxhia6193o6vqbqh0lu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."registro_movimentação"
    ADD CONSTRAINT fkr9pge4nxhia6193o6vqbqh0lu FOREIGN KEY (estoque_id) REFERENCES public.estoque(id);


-- Completed on 2024-08-22 00:05:52

--
-- PostgreSQL database dump complete
--

